package net.mzouabi.ng2.server.util;

/**
 * Created by jayani on 7/5/17.
 */
public class ResponseBuilder<NEXT> extends BaseBuilder<Response, NEXT> {
  Response response = null;

  public ResponseBuilder(Response response, NEXT next) {
    super(next, response);
  }

  public static DataPhase<Immutable<Response>> create() {
    Response response = new Response();
    return new DataPhase(new ResponseBuilder(response, new Immutable(response)));
  }

  public static class DataPhase<N> extends BaseBuilder.BasePhase<N, Response, ResponseBuilder<N>> {

    public DataPhase(ResponseBuilder responseBuilder) {
      super(responseBuilder);
    }

    public MassagePhase<N> withData(Object data) {
      this.getTarget().setData(data);
      return new MassagePhase(this.parent);
    }
  }

  public static class MassagePhase<N> extends BaseBuilder.BasePhase<N, Response, ResponseBuilder<N>> {

    public MassagePhase(ResponseBuilder<N> responseBuilder) {
      super(responseBuilder);
    }

    public N withMessage(String massage) {
      this.getTarget().setMessage(massage);
      return this.getNextPharse();
    }
  }

}
