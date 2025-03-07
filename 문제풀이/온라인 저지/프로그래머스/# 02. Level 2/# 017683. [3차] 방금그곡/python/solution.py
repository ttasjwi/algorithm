convert_dict = {'C#': 'H', 'D#': 'I', 'F#': 'J', 'G#': 'K', 'A#': 'L', 'B#': 'M', 'E#': 'N'}


def solution(m, musicinfos):
    answer = '(None)'
    max_played_time = -1

    for music_info in musicinfos:
        start_str, end_str, music_name, music = music_info.split(',')
        played_time = get_played_time(start_str, end_str)
        music = convert(music)
        extended_music = extend_music(music, played_time)
        if convert(m) in extended_music and max_played_time < played_time:
            max_played_time = played_time
            answer = music_name
    return answer


def extend_music(music, played_time):
    q, r = divmod(played_time, len(music))
    return (music * q) + music[:r]


def convert(music):
    current_idx = 0
    result = []
    while current_idx < len(music):
        if current_idx + 1 < len(music) and music[current_idx + 1] == '#':
            result.append(convert_dict[music[current_idx:current_idx + 2]])
            current_idx += 2
        else:
            result.append(music[current_idx])
            current_idx += 1
    return ''.join(result)


def get_played_time(start_str, end_str):
    start_min = parse_min(start_str)
    end_min = parse_min(end_str)
    return end_min - start_min


def parse_min(time_str):
    h, m = map(int, time_str.split(':'))
    return h * 60 + m
