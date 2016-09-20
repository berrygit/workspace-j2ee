package oval;

import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

public class Test {
	public static void main(String[] args) {
		RequestBean requestBean = new RequestBean();

		Validator validator = new Validator();

		List<ConstraintViolation> violations = validator.validate(requestBean);

		for (ConstraintViolation violation : violations) {
			String errorCode = violation.getErrorCode();
			String message = violation.getMessage();
			System.out.println(errorCode + " : " + message);
		}
	}
}
