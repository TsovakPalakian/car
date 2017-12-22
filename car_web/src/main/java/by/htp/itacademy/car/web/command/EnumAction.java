package by.htp.itacademy.car.web.command;

public enum EnumAction {
	
	LOG_IN {
		@Override
		public Action getAction() {
			return null;
		}
	};
	public abstract Action getAction();
}
