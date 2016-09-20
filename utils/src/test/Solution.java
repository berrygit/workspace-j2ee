package test;

public class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().countDigitOne(1633388154));
	}

	public int countDigitOne(int n) {

		if (n < 0) {
			return 0;
		}

		int count = 0;
		int mod = 0;
		int postMask = 1;

		while (postMask <= 1000000000 && n / postMask != 0) {

			mod = (n / postMask) % 10;

			switch (mod) {
				case 0 :
					count += postMask;
					count += postMask * (n / (postMask * 10) - 1);
					break;
				case 1 :
					if (postMask <= 100000000 && n / (postMask * 10) != 0) {
						count += postMask;

						if (n / (postMask * 10) > 1) {
							count += ((n / (postMask * 10)) - 1) * postMask;
						}
					}
					count += n % postMask + 1;
					break;
				default :
					if (postMask <= 100000000 && n / (postMask * 10) != 0) {
						count += postMask * (n / (postMask * 10));
					}
					count += postMask;
					break;

			}
			postMask *= 10;
		}
		return count;
	}
}