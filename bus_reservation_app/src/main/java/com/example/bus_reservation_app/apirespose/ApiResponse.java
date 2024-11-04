package com.example.bus_reservation_app.apirespose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Component
public class ApiResponse {
    private String message;
    private Object status;
    private Object data;

    public <E> ApiResponse(String signUpSuccessfully, ArrayList<E> es) {
    }
}
