import { Column, Entity, PrimaryColumn } from "typeorm";

@Entity()
export class KeyStore {
    @PrimaryColumn('varchar')
    username: string;

    @Column({
        type: 'varchar',
        length: 5000
    })
    publicKey: string;

    @Column({
        type: 'varchar',
        length: 5000
    })
    privateKey: string;
}