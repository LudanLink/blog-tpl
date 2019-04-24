package link.xuchen.global.exception.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import link.xuchen.global.exception.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Create with IDEA
 * Ludan
 * Data:2019/4/16 2:16 PM
 * Description: TODO
 */
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageDTO<T extends BaseEntity> {

    private static MessageDTO messageDTO;

    private Integer code;
    private String message;
    private boolean isSuccess;
    private String error;
    private T data;

    public MessageDTO() {}

    public static MessageDTO build() {
        messageDTO = new MessageDTO();
        return messageDTO;
    }

    public MessageDTO success(String message, T attributes) {
        messageDTO.setCode(200);
        messageDTO.setSuccess(true);
        messageDTO.setMessage(message);
        messageDTO.setData(attributes);
        return messageDTO;
    }

    public MessageDTO error(Integer code, String error) {
        messageDTO.setCode(code);
        messageDTO.setSuccess(false);
        messageDTO.setError(error);
        return messageDTO;
    }

}
