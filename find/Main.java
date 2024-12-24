import java.io.*;
import java.util.*;

class Main {

	private final static int CMD_ADD = 1;
	private final static int CMD_FIND = 2;

	private static boolean run(BufferedReader br) throws IOException {

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		usersolution.init(); 

		int id;
		String name;
		String userAns;
		String ans;
		boolean isCorrect = true;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			switch (cmd) 
			{
				case CMD_ADD:
					id = Integer.parseInt(st.nextToken());
					name = st.nextToken();
					usersolution.add(id, name);
					break; 
	
				case CMD_FIND:
					ans = st.nextToken();
					id = Integer.parseInt(st.nextToken());
					userAns = usersolution.find(id);
					if (!userAns.equals(ans)) {
						isCorrect = false;
					}
					break;

				default:
					isCorrect = false;
					break;
			}
		}
		return isCorrect;
	}

	private final static UserSolution usersolution = new UserSolution();

	public static void main(String[] args) throws Exception {

		// System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		int MARK = Integer.parseInt(st.nextToken());

		for (int testcase = 1; testcase <= TC; testcase++) {
			int score = run(br) ? MARK : 0;
			System.out.println("#" + testcase + " " + score);
		}

		br.close();
	}
}
