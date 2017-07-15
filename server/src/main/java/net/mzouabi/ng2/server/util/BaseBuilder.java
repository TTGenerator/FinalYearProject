package net.mzouabi.ng2.server.util;

/**
 * Created by jayani on 7/8/17.
 */
public class BaseBuilder<TARGET, NEXT> {
  NEXT next;
  TARGET target;

  public BaseBuilder(NEXT next, TARGET target) {
    this.next = next;
    this.target = target;
  }

  public NEXT getNext() {
    return next;
  }

  public TARGET getTarget() {
    return target;
  }

  public static class BasePhase<N, TARGET, BUILDER extends BaseBuilder<TARGET, N>> {
    protected BUILDER parent;

    public BasePhase(BUILDER parent) {
      this.parent = parent;
    }

    public TARGET getTarget() {
      return this.parent.getTarget();
    }

    public N getNextPharse() {
      return this.parent.getNext();
    }
  }
}
