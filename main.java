import java.io.*;
import java.util.*;

class Main {

	private final static int CMD_SUM  = 1;
	private final static int CMD_SUB = 2;
	private final static int CMD_MUL = 3;
	private final static int CMD_DIV = 4;
	private static boolean run(BufferedReader br) throws IOException {

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int Q = Integer.parseInt(st.nextToken());

		boolean isCorrect = true; 
		int cal;
		int A,B;
		int userAns, ans; 

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			cal = Integer.parseInt(st.nextToken());
			switch(cal) 
			{
				case CMD_SUM:
					A = Integer.parseInt(st.nextToken());
					B = Integer.parseInt(st.nextToken());
					ans = Integer.parseInt(st.nextToken());
					userAns = usersolution.sum(A,B);
					if(ans != userAns) 
						isCorrect = false; 
					break;
				
				case CMD_SUB:
					A = Integer.parseInt(st.nextToken());
					B = Integer.parseInt(st.nextToken());
					ans = Integer.parseInt(st.nextToken());
					userAns = usersolution.sub(A,B);
					if(ans != userAns) 
						isCorrect = false; 
					break;
					
				case CMD_MUL:
					A = Integer.parseInt(st.nextToken());
					B = Integer.parseInt(st.nextToken());
					ans = Integer.parseInt(st.nextToken());
					userAns = usersolution.mul(A,B);
					if(ans != userAns) 
						isCorrect = false; 
					break;
	
				case CMD_DIV:
					A = Integer.parseInt(st.nextToken());
					B = Integer.parseInt(st.nextToken());
					ans = Integer.parseInt(st.nextToken());
					userAns = usersolution.div(A,B);
					if(ans != userAns) 
						isCorrect = false; 
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
