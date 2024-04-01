package org.pratice.banking.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder
public class BaseRespone<T> {
   private T Paylot;
   private String message;
   private Object object;
   private  int status;
   public static <T> BaseRespone <T> creatSuccess()
   {
       return new BaseRespone<T>()
               .setStatus(HttpStatus.CREATED.value())
               .setMessage("Create successfully");
   }

}
