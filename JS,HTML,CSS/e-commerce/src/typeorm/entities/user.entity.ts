import { IsEmail } from "class-validator";
import { Column, Entity, PrimaryColumn } from "typeorm";

@Entity()
export class User {
    @PrimaryColumn('varchar')
    username: string;

    @Column('varchar')
    password: string;

    @Column({
        type: 'enum',
        enum: ['member', 'admin'],
        default: 'member'
    })
    role: string;

    @Column('varchar')
    @IsEmail()
    email: string;

    @Column({ type: "json" })
    own_store: string[];

    @Column('varchar')
    createdAt: Date;
}