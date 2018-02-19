package by.htp.itacademy.car.web.command;

import by.htp.itacademy.car.web.command.impl.LogInAction;
import by.htp.itacademy.car.web.command.impl.LogInPageAction;
import by.htp.itacademy.car.web.command.impl.SignUpPageAction;

public enum EnumAction {
	
	LOG_IN {
		@Override
		public Action getAction() {
			return LogInAction.getInstance();
		}
	},
	LOG_IN_PAGE {
		@Override
		public Action getAction() {
			return LogInPageAction.getInstance();
		}
	},
	SIGN_UP_PAGE {
		@Override
		public Action getAction() {
			return SignUpPageAction.getInstance();
		}
	};
	
	public abstract Action getAction();
}
