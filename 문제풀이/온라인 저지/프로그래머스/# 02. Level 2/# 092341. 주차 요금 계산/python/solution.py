def solution(fees, records):
    basic_minute, basic_price, unit_minute, unit_price = fees

    # 입출차 기록 파싱
    def parse_record(record):
        time_str, car_number, in_out_str = record.split()
        hour, minute = map(int, time_str.split(":"))
        return hour * 60 + minute, car_number, in_out_str == 'IN'

    # 머문 시간에 따른 요금 계산
    def calculate_price(stay_minute):
        if stay_minute <= basic_minute:
            return basic_price
        else:
            # 초과시간을 단위 시간으로 나눈 몫, 나머지
            q, r = divmod(stay_minute - basic_minute, unit_minute)

            # 나머지가 있으면 몫을 올림처리
            if r > 0:
                q += 1
            return basic_price + q * unit_price

    car_in_times = {}  # 들어와 있는 차량들별 입차시각
    stay_minutes = {}  # 차량별 누적 머문 시각

    for record in records:
        current_time, car_number, is_in = parse_record(record)

        # 입차일 경우
        if is_in:
            if car_number not in stay_minutes:
                stay_minutes[car_number] = 0
            # 차량이 현재 입차한 시각을 기록
            car_in_times[car_number] = current_time
        else:
            # 입차시각을 조회하고, 머문 시간을 추가, 그 후 입차기록에서 제거
            in_time = car_in_times[car_number]
            stay_minutes[car_number] = stay_minutes[car_number] + (current_time - in_time)
            car_in_times.pop(car_number)

    # 마지막까지 출차하지 않은 차들은 23:59 에 출차한 것으로 처리
    for car_number, in_time in car_in_times.items():
        stay_minutes[car_number] = stay_minutes[car_number] + (1439 - in_time)

    # 차량별 청구요금 반환
    return [calculate_price(stay_minutes[car_number]) for car_number in sorted(stay_minutes.keys())]
