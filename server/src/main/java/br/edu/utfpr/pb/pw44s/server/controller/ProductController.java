package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.error.ApiError;
import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.service.IProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> save(Product product) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.productService.save(product));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleException(MethodArgumentNotValidException exception,
                                    HttpServletRequest request) {
        // Recupero o objeto com o conjunto de erros
        BindingResult bindingResult = exception.getBindingResult();
        Map<String, String> errors = new HashMap<>();
        // Monto o array com nome do atributo: mensagem de erro
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Error!",
                request.getServletPath(),
                errors);
    }
}
