package net.mzouabi.ng2.server.util;

/**
 * Created by jayani on 7/8/17.
 */
public class BaseBuilder<NEXT, TARGET> {
  NEXT next;
  TARGET target;

  public NEXT getNext() {
    return next;
  }

  public void setNext(NEXT next) {
    this.next = next;
  }

  public TARGET getTarget() {
    return target;
  }

  public void setTarget(TARGET target) {
    this.target = target;
  }
}
