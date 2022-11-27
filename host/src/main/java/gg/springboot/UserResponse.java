package main.java.gg.springboot;

public class UserResponse {
    private String message;
    private int data;

    // Getter
    public String getMessage() {
        return message;
    }

    public int getData() {
        return data;
    }

    // Setter
    public void setMessage(String c) {
        this.message = c;
    }

    public void setData(int m) {
        this.data = m;
    }
}