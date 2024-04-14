import { Column, Entity, MixedList, PrimaryColumn } from "typeorm";


@Entity()
export class Product {
    @PrimaryColumn('varchar')
    product_id: string;

    @Column('varchar')
    product_name: string;

    @Column('varchar')
    product_thumb: string;

    @Column('int')
    product_price: number;

    @Column('int')
    product_quantity: number;

    @Column('varchar')
    product_description: string;

    @Column({ type: 'enum', enum: ['Paper rice'] })
    product_type: string;

    @Column('varchar')
    product_shop: string;

    @Column('json')
    product_attributes: object;
}

