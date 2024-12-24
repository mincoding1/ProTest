int main() {
	int T;
	int score;
	int N;
	int id;
	string name;
	string userAns;
	string ans;
	bool isCorrect = true;

	cin >> T >> score;
	for (int t = 1; t <= T; t++) {
		init();
		cin >> N;
		for (int i = 0; i < N; i++) {
			int cmd;
			cin >> cmd;
			if (cmd == 1) {
				cin >> id >> name;
				add(id, name);
			}
			if (cmd == 2) {
				cin >> ans >> id;
				if (find(id) != ans)isCorrect = false;
			}
		}
		if (isCorrect) {
			cout << "#" << t << " " << score <<"\n";
			continue;
		}
		cout << "#" << t << " " << 0 <<"\n";
	}
	return 0;
}
