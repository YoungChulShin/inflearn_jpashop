package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter @Setter
public class Delivery {

    private Long id;

    private Order orde;

    private Address address;

    private DeliveryStatus status;
}
