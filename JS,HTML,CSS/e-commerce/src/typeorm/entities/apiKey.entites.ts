import { Column, Entity, PrimaryColumn } from "typeorm";

@Entity()
export class ApiKey {

    @PrimaryColumn({ unique: true })
    apiKeyCode: string;

    @Column('boolean')
    status: boolean;

    @Column('varchar')
    permission: string;

    @Column('varchar')
    createAt: Date;


}