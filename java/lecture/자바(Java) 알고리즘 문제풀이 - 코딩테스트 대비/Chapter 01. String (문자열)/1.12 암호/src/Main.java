    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;

    public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();

            String answer = solution(line, n);
            System.out.print(answer);
        }

        private static String solution(String line, int n) {
            StringBuilder mainSb = new StringBuilder();

            for (int i=0; i<n; i++) {

                StringBuilder subSb = new StringBuilder();

                for (int j=0; j<7; j++) {
                    int index = 7*i + j;
                    if (line.charAt(index) == '#') {
                        subSb.append(1);
                    } else {
                        subSb.append(0);
                    }
                }
                int value = Integer.parseInt(subSb.toString(), 2);
                mainSb.append((char) value);
            }
            return mainSb.toString();
        }
    }
