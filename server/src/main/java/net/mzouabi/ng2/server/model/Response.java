package net.mzouabi.ng2.server.model;

/**
 * Created by Jayani on 7/4/17.
 */
public class Response<T> {
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  private String message;
  private T data;

  public boolean isValid() {
    return valid;
  }

  public void setValid(boolean valid) {
    this.valid = valid;
  }

  private boolean valid;
}
