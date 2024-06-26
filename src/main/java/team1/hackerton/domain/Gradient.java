package team1.hackerton.domain;

import jakarta.persistence.*;
import lombok.*;
import team1.hackerton.domain.common.BaseEntity;
import team1.hackerton.domain.enums.Type;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Gradient extends BaseEntity {

    @Id
    @Column(name = "gradient_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gradientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private String name;

    private String description;

    private Type type;

    public Gradient(Item item, String name, String description, Type type) {
        this.item = item;
        this.name = name;
        this.description = description;
        this.type = type;
    }
}
