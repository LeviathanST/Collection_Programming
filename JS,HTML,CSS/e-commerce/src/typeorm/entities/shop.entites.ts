import { IsString } from "class-validator";
import { Column, Entity, ObjectId, ObjectIdColumn, PrimaryColumn, PrimaryGeneratedColumn } from "typeorm";

@Entity()
export class Shop {
    @PrimaryGeneratedColumn('uuid')
    shop_id: string;
    
    @Column('varchar')
    shop_name: string;
    
    @Column({ type: 'varchar', nullable: true, default: null })
    shop_thumb: string;
    
    @Column('varchar')
    shop_owner: string;
}