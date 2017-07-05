package net.mzouabi.ng2.server.model;

/**
 * Created by Jayani on 7/5/17.
 */
public class ResponseBuilder <T>{
    Response response = null;
    public void create(){
        this.response = new Response();
    }

    public Response<T> get(){
        return response;
    }
}
