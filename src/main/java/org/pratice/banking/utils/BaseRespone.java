package org.pratice.banking.utils;

import lombok.*;
import lombok.experimental.Accessors;
import org.pratice.banking.feature.user.UserService;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder
public class BaseRespone<T> {
   private T Paylot;
   private String message;
   private  int status;
   private Object metadata;
   public static <T> BaseRespone <T> creatSuccess()
   {
       return new BaseRespone<T>()
               .setStatus(HttpStatus.CREATED.value())
               .setMessage("Create successfully");
   }
   public static <T> BaseRespone <T> OK()
   {
       return new BaseRespone<T>()
               .setStatus(HttpStatus.OK.value())
               .setMessage("Get All Product Success");
   }
   public static <T> BaseRespone <T> Found()
   {
      return new BaseRespone<T>()
                .setStatus(HttpStatus.FOUND.value())
                .setMessage("Get Product Success");
   }
   public static <T> BaseRespone <T> Delete()
   {
       return new BaseRespone<T>()
               .setStatus(HttpStatus.OK.value())
               .setMessage("Delete Product Success");
   }
   public static <T> BaseRespone <T> NotFound()
   {
       return new BaseRespone<T>()
               .setStatus(HttpStatus.NOT_FOUND.value())
               .setMessage("Product Not Found");
   }
   public static <T> BaseRespone <T> updateSuccess()
   {
       return new BaseRespone<T>()
               .setStatus(HttpStatus.OK.value())
               .setMessage("Update Product Success");
   }

}
