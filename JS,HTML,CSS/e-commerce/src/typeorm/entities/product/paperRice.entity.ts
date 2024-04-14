import { Column, Entity, PrimaryColumn } from "typeorm";


@Entity()
export class PaperRice {
    @PrimaryColumn('varchar')
    product_id: string;

    @Column('json')
    product_ingredient: string[];
}

