package Structures;

public enum OrderType {
		Platinum(1), Gold(2), Bronze(3);
		private int value;

		private OrderType(int value) {
			this.value = value;

		}

}
