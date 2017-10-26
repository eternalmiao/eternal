package cn.bean;

public class TokenCount {
		private int id;
	    private String token;
	    private int spam;		// �˹ؼ����������ʼ��г��ֵĴ���
	    private int spamAll;	    // �����ʼ�������
	    private int normal;		// �˹ؼ����������ʼ��г��ֵĴ���
	    private int normalAll;	// �����ʼ�������
	    private double probability;// ����ؼ��ʴ��ڵ������,�������ʼ��ĸ���
	    
		public TokenCount() {
			super();
		}
		
		public TokenCount(String token, int spam, int spamAll, int normal, int normalAll, double probability) {
			super();
			this.token = token;
			this.spam = spam;
			this.spamAll = spamAll;
			this.normal = normal;
			this.normalAll = normalAll;
			this.probability = probability;
		}
		
		public TokenCount(int id, String token, int spam, int spamAll, int normal, int normalAll,
				double probability) {
			super();
			this.id = id;
			this.token = token;
			this.spam = spam;
			this.spamAll = spamAll;
			this.normal = normal;
			this.normalAll = normalAll;
			this.probability = probability;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.token = token;
		}

		public int getSpam() {
			return spam;
		}

		public void setSpam(int spam) {
			this.spam = spam;
		}

		public int getSpamAll() {
			return spamAll;
		}

		public void setSpamAll(int spamAll) {
			this.spamAll = spamAll;
		}

		public int getNormal() {
			return normal;
		}

		public void setNormal(int normal) {
			this.normal = normal;
		}

		public int getNormalAll() {
			return normalAll;
		}

		public void setNormalAll(int normalAll) {
			this.normalAll = normalAll;
		}

		public double getProbability() {
			return probability;
		}

		public void setProbability(double probability) {
			this.probability = probability;
		}
	    
		
		public void setSpamAdd(int num) {
			spam += num;
		}
		
		public void setSpamAllAdd(int num) {
			spamAll += num;
		}
		
		public void setNormalAdd(int num) {
			normal += num;
		}
		
		public void setNormalAllAdd(int num) {
			normalAll += num;
		}
		
		@Override
		public String toString()
		{
			return "[token=" + token + ", spam=" + spam + ", spamAll=" + spamAll + ", normal=" + normal + ", normalAll=" + normalAll + ", probability="
					+ probability + "]";
		}
	    
}
