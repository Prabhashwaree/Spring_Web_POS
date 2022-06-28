package lk.ijse.springwebpos.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ResponceUtil {
    private int code;
    private String massage;
    private Object data;
}
