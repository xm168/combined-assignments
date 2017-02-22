package com.cooksys.ftd.assignments.objects;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Rational implements IRational {
	
	private int num, dem;

    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * No simplification of the numerator/denominator pair should occur in this method.
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
	
    public Rational(int numerator, int denominator) throws IllegalArgumentException {
    	if(denominator == 0)
    			throw new IllegalArgumentException();
    	this.num = numerator;
    	this.dem = denominator;
       }

    /**
     * @return the numerator of this rational number
     */
    @Override
    public int getNumerator() {    	
        return num;
    }

    /**
     * @return the denominator of this rational number
     */
    @Override
    public int getDenominator() {
        return dem;
    }

    /**
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public Rational construct(int numerator, int denominator) throws IllegalArgumentException {
    	
    	if(denominator == 0)
            throw new IllegalArgumentException();
    	
        	
            int g = gcd(numerator, denominator);
            num = numerator/g;
            dem = denominator/g;
//            if ( denominator < 0 ) num = -num;
			return new Rational(num, dem);
   
           }
        	
        private int gcd(int n, int d){
            int r = n % d;
            while (r != 0){
            n = d;
            d = r; 
            r = n % d;
            }
			return d;
        }

    /**
     * @param obj the object to check this against for equality
     * @return true if the given obj is a rational value and its
     * numerator and denominator are equal to this rational value's numerator and denominator,
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) {
    	
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;
        return obj instanceof Rational
                && ((Rational)obj).num == num
                && ((Rational)obj).dem == dem;
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
