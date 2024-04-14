import { Module } from "@nestjs/common";
import { TypeOrmModule } from "@nestjs/typeorm";
import { Product } from "src/typeorm/entities/product.entity";
import { PaperRice } from "src/typeorm/entities/product/paperRice.entity";



@Module({
    imports: [TypeOrmModule.forFeature([Product, PaperRice])],
    controllers: [],
    providers: [],
    exports: []
})

export class ProductModule { }