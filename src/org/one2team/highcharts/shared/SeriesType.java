package org.one2team.highcharts.shared;



public enum SeriesType {
  table {
    @Override
    public <IN, OUT> OUT accept (SeriesTypeVisitor<IN, OUT> visitor, IN in) {
      return visitor.visitTable (this, in);
    }
  },
  column {
    @Override
    public <IN, OUT> OUT accept (SeriesTypeVisitor<IN, OUT> visitor, IN in) {
      return visitor.visitColumn (this, in);
    }
  }, 
  area {
    @Override
    public <IN, OUT> OUT accept (SeriesTypeVisitor<IN, OUT> visitor, IN in) {
      return visitor.visitArea (this, in);
    }
  }, 
  areaspline {
    @Override
    public <IN, OUT> OUT accept (SeriesTypeVisitor<IN, OUT> visitor, IN in) {
      return visitor.visitAreaspline (this, in);
    }
  }, 
  bar {
    @Override
    public <IN, OUT> OUT accept (SeriesTypeVisitor<IN, OUT> visitor, IN in) {
      return visitor.visitBar (this, in);
    }
  }, 
  line {
    @Override
    public <IN, OUT> OUT accept (SeriesTypeVisitor<IN, OUT> visitor, IN in) {
      return visitor.visitLine (this, in);
    }
  }, 
  pie {
    @Override
    public <IN, OUT> OUT accept (SeriesTypeVisitor<IN, OUT> visitor, IN in) {
      return visitor.visitPie (this, in);
    }
  }, 
  scatter {
    @Override
    public <IN, OUT> OUT accept (SeriesTypeVisitor<IN, OUT> visitor, IN in) {
      return visitor.visitScatter (this, in);
    }
  }, 
  spline {
    @Override
    public <IN, OUT> OUT accept (SeriesTypeVisitor<IN, OUT> visitor, IN in) {
      return visitor.visitSpline (this, in);
    }
  };
  
  public abstract <IN, OUT> OUT accept (SeriesTypeVisitor<IN, OUT> visitor, IN in);
  
}