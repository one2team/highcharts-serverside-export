package org.one2team.highcharts.shared;

public interface Tooltip {

  Tooltip setShared (boolean shared);

  Tooltip setFormatter (Object formatter);

  Tooltip setCrosshairs (boolean b);

  boolean isShared ();

  boolean isCrosshairs ();

  Object getFormatter ();
}
