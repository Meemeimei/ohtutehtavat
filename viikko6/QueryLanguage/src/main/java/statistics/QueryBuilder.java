
package statistics;

import statistics.matcher.*;

public class QueryBuilder {
    Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new Matcher() {
            @Override
            public boolean matches(Player p) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
    
    public Matcher build() {
        return matcher;
    }
    
    public QueryBuilder all() {
        this.matcher = new All();
        return this;
    }
    
    public QueryBuilder and(Matcher... matchers) {
        this.matcher = new And(matchers);
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        and(new HasAtLeast(value, category), matcher);
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        and(new HasFewerThan(value, category), matcher);
        return this;
    }
    
    public QueryBuilder not(Matcher... matchers) {
        this.matcher = new Not(matchers);
        return this;
    }
    
    public QueryBuilder or(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matcher = new PlaysIn(team);
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        or(matchers);
        return this;
    }
}
