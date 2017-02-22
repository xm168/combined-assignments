package com.cooksys.ftd.assignments.objects;


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SimplifiedRational implements IRational {
	
	private int num, dem;

    /**
     * Determines the greatest common denominator for the given values
     *
     * @param a the first value to consider
     * @param b the second value to consider
     * @return the greatest common denominator, or shared factor, of `a` and `b`
     * @throws IllegalArgumentException if a <= 0 or b < 0
     */
    public static int gcd(int a, int b) throws IllegalArgumentException {
    	if(a<=0 || b<0)
        throw new IllegalArgumentException();
    	if(b==0) return a;
    	else
		return gcd(b, a%b);
    }

    /**
     * Simplifies the numerator and denominator of a rational value.
     * <p>
     * For example:
     * `simplify(10, 100) = [1, 10]`
     * or:
     * `simplify(0, 10) = [0, 1]`
     *
     * @param numerator   the numerator of the rational value to simplify
     * @param denominator the denominator of the rational value to simplify
     * @return a two element array representation of the simplified numerator and denominator
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public static int[] simplify(int numerator, int denominator) throws IllegalArgumentException {
    	
    	if(denominator == 0)
            throw new IllegalArgumentException();
    	
        int g = gcd(numerator, denominator);
        int num = numerator/g;
        int dem = denominator/g;
        if ( denominator < 0 ){ num = -num; dem = Math.abs(dem);}
		return new int[]{num, dem};

    }

    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * Simplification of numerator/denominator pair should occur in this method.
     * If the numerator is zero, no further simplification can be performed
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public SimplifiedRational(int numerator, int denominator) throws IllegalArgumentException {
    	
    	if(denominator == 0)
			throw new IllegalArgumentException();

    	if(numerator == 0)
    		return;
    	
    	int[] simplifiedResult = simplify(numerator, denominator);
    	this.num = simplifiedResult[0];
    	this.dem = simplifiedResult[1];
    }

    /**
     * @return the numerator of this rational number
     */
    @Override
    public int getNumerator() {
        return this.num;
    }

    /**
     * @return the denominator of this rational number
     */
    @Override
    public int getDenominator() {
        return this.dem;
    }

    /**
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator   the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value (specifically, a SimplifiedRational value)
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public SimplifiedRational construct(int numerator, int denominator) throws IllegalArgumentException {
    	SimplifiedRational simplifiedRational;
    	 num = numerator;
    	 dem = denominator;

    	if(dem == 0)
			throw new IllegalArgumentException();
    	
    	int[] simplifiedResult = simplify(num, dem);
    	num = simplifiedResult[0];
    	dem = simplifiedResult[1];
  	
    	simplifiedRational = new SimplifiedRational(num, dem);
    	
    	return simplifiedRational;
    }
    
    public SimplifiedRational negate() throws IllegalArgumentException{
    	
    	SimplifiedRational simplifiedRational = (SimplifiedRational) IRational.super.negate();
    	return simplifiedRational;
    }

    public SimplifiedRational invert() throws IllegalArgumentException{
    	
    	SimplifiedRational simplifiedRational = (SimplifiedRational) IRational.super.invert();
    	return simplifiedRational;
    }

    
    public SimplifiedRational add(IRational that) throws IllegalArgumentException{
    	
       	if(that == null)
            throw new IllegalArgumentException();
       	SimplifiedRational simplifiedRational = (SimplifiedRational) IRational.super.add(that);
    	return simplifiedRational;
    }
    
    public SimplifiedRational sub(IRational that) throws IllegalArgumentException{
    	
       	if(that == null)
            throw new IllegalArgumentException();
       	SimplifiedRational simplifiedRational = (SimplifiedRational) IRational.super.sub(that);
    	return simplifiedRational;
    }
    
    public SimplifiedRational mul(IRational that) throws IllegalArgumentException{
    	
       	if(that == null)
            throw new IllegalArgumentException();
       	SimplifiedRational simplifiedRational = (SimplifiedRational) IRational.super.mul(that);
    	return simplifiedRational;
    }

    public SimplifiedRational div(IRational that) throws IllegalArgumentException{
    	
       	if(that == null)
            throw new IllegalArgumentException();
    	if(dem == 0)
			throw new IllegalArgumentException();
       	
       	SimplifiedRational simplifiedRational = (SimplifiedRational) IRational.super.div(that);
    	return simplifiedRational;
    }


    /**
     * @param obj the object to check this against for equality
     * @return true if the given ob j is a rational value and its
     * numerator and denominator are equal to this rational value's numerator and denominator,
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        return obj instanceof SimplifiedRational
                && ((SimplifiedRational)obj).num == num
                && ((SimplifiedRational)obj).dem == dem;
    }

    /**
     * If this is positive, the string should be of the form `numerator/denominator`
     * <p>
     * If this is negative, the string should be of the form `-numerator/denominator`
     *
     * @return a string representation of this rational value
     */
    @Override
    public String toString() {
    	int n = this.getNumerator();
        int d = this.getDenominator();
    	
        if (n < 0 != d < 0 ) 
        	return (""+ (-1)*Math.abs(n) + "/" + Math.abs(d));        	
        else        
        	return (""+ Math.abs(n) + "/" + Math.abs(d));

    }
}
