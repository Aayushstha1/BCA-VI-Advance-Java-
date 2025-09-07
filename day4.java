// you are asked to write a discount system for a beauty salon, which provides services and sell beauty product.
//it offers 3 types of memberships: premium, gold and silver. premium, gold and silver member receive a discount of 20%,15% and 10%, respectively for all services provided.Customer without member  recive no discount.
// All members recive a flat 10% discount discount on the product purchased(this might change in future).
// your system shall consist of three classes: customer, discount and vist.
// it shall compute the total bill if a customer purchase $x of products and $y of services for a visit
// also write a test program to exercise all the class


package corejava;

class Customer {
    private String name;
    private boolean member;
    private String memberType;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setMember(boolean member) {
        this.member = member;
    }

    boolean isMember() {
        return member;
    }

    void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    String getMemberType() {
        return memberType;
    }
}

class Discount{
     double getServiceDiscount(String getMember)
}


public class day4 {
    
}
