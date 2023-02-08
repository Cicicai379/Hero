public class Hero {
    private String name;
    private int hitPoints;
    public Hero(String name){
        this.name=name;
        this.hitPoints=100;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }


    public String toString() {
        return "Hero{name=\'" + this.name+ "\', hitPoints="+this.hitPoints+"}";
    }
    public boolean attack(Hero opp){
        double r = Math.random();
        if(r<0.5){
            opp.hitPoints-=10;
            return false;
        }else{

            this.hitPoints-=10;
            return true;
        }

    }
    public void senzuBean(){
        this.hitPoints=100;
    } //restore hitpoints
    private void fightUntilTheDeathHelper(Hero opp){
        while(opp.hitPoints>0&&this.hitPoints>0){//attack until dead
            attack(opp);
        }
    }
    public String fightUntilTheDeath(Hero opp){
        while(opp.hitPoints>0&&this.hitPoints>0){
            attack(opp);
        }
       return (this.name+": "+this.hitPoints+"\t"+opp.name+": "+opp.hitPoints);
    }

    private void nFightsToTheDeathHelper(Hero opp, int n){
        while(opp.hitPoints>0&&this.hitPoints>0){ //keep attaking until one is dead
            attack(opp);
            n--;
        }
        opp.senzuBean();
        this.senzuBean();
        while(n>0){//remaining rights
            attack(opp);
            n--;
        }
    }
    public String nFightsToTheDeath(Hero opp, int n){
        int o=0;
        int m=0;
        while(opp.hitPoints>0&&this.hitPoints>0){
            if( attack(opp)){
                o++;
            }else{
                m++;
            }
            n--;
        }
        opp.senzuBean();
        this.senzuBean();
        while(n>0){//attack remaining fights

            if( attack(opp)){//count wins
                o++;
            }else{
                m++;
            }
            n--;
        }
        String ans=this.name+": "+m+" wins"+"\n"+opp.name+": "+o+" wins";
        if(o>m){
            ans+="\n"+opp.name+" wins!";
        }else if(o<m){
            ans+="\n"+this.name+" wins!";
        }else{
            ans+="\n"+"OMG! It was actually a draw!";
        }
        return ans;
    }

    public String dramaticFightsToTheDeath(Hero opp, int n){
        int o=0;
        int m=0;
        String ans="";
        while(opp.hitPoints>0&&this.hitPoints>0){ // keep attacking until one is dead

            if( attack(opp)){
                ans=opp.name+": "+"\n"+opp.getHitPoints()+": "+o+" \n\n";
                o++;
            }else{
                ans=this.name+": "+"\n"+this.hitPoints+": "+o+" \n\n";
                m++;
            }
            n--;
        }

        if(o>m){
            ans+="\n"+opp.name+" wins!";
        }else if(o<m){
            ans+="\n"+this.name+" wins!";
        }else{
            ans+="\n"+"OMG! It was actually a draw!";
        }
        return ans;
    }
}

