package com.emre.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_ERROR(5100, "Sunucu Hatası", HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4100, "Parametre Hatası", HttpStatus.BAD_REQUEST),
    LOGIN_ERROR(4110, "Hatalı kullanıcı adı veya şifre hatalı", HttpStatus.BAD_REQUEST),
    PASSWORD_ERROR(4120, "Şifreler aynı değil", HttpStatus.BAD_REQUEST),
    USERNAME_DUPLICATE(4111, "Bu kullanıcı zaten kayıtlı", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4112, "Böyle bir kullanıcı bulunamadı", HttpStatus.NOT_FOUND),
    USER_FOUND(4112, "Böyle bir kullanıcı çoktan var", HttpStatus.NOT_FOUND),
    RESTAURANT_NOT_FOUND(4201,"Bu restaurant bulunamadı",HttpStatus.NOT_FOUND),
    RESTAURANT_PRODUCT_ALREADY_EXIST(4202,"Bu ürün bu restaurantta kayıtlı",HttpStatus.FOUND),
    RESTAURANT_ALREADY_FOUND(4112, "Bu adreste restorant vardır,adresi doğru yazdığınıza emin olunuz.", HttpStatus.NOT_FOUND),
    ORDER_DIFFERENT_RESTAURANT(4200,"Aynı anda farklı restaurantlardan sipariş veremezsiniz!",HttpStatus.BAD_REQUEST),
    USER_NOTACTIVE(4112, "Kullanıcı aktif değildir", HttpStatus.NOT_FOUND),
    ACTIVATE_CODE_ERROR(4113, "Aktivasyon kod hatası", HttpStatus.BAD_REQUEST),
    TOKEN_NOT_CREATED(4700,"Token üretilemedi",HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(4600,"Token hatası" ,HttpStatus.BAD_REQUEST );
    private int code;
    private String message;
    HttpStatus httpStatus;

}
