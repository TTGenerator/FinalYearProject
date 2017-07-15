package net.mzouabi.ng2.server.util;

/**
 * Created by jayani on 7/15/17.
 */
public class Immutable<TARGET> {
  TARGET target;

  public Immutable(TARGET target) {
    this.target = target;
  }

  public TARGET get() {
    return target;
  }
}
