package link.xuchen.global.exception.exceptions;

/**
 * Create with IDEA
 * Ludan
 * Data:2019/4/16 3:43 PM
 * Description: TODO
 */
public class BusinessException extends RuntimeException {

    public BusinessException(){
        super();
    }

    public BusinessException(String message){
        super(message);
    }
}