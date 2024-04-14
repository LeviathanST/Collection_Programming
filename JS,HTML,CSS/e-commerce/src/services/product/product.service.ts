import { Injectable } from "@nestjs/common";
import { InjectRepository } from "@nestjs/typeorm";
import { createProductDto } from "src/dtos/product.dto";
import { Product } from "src/typeorm/entities/product.entity";
import { PaperRice } from "src/typeorm/entities/product/paperRice.entity";

import { Repository } from "typeorm";


/*  
    product_name: string;
    product_id: string;
    product_thumb: string;
    product_price: string;
    product_quantity: number;
    product_description: string;
    product_type: string;
    product_shop: string;
    product_attributes: object;
*/



@Injectable()
class ProductFactory {
    constructor(
        private paperRiceService: PaperRiceService,
    ) { }

    createProduct(type: string, payload: createProductDto) {
        switch (type) {
            case 'Paper Rice':
                return this.paperRiceService.createProduct(payload);


            default:
                break;
        }
    }


}


class ProductService {
    @InjectRepository(Product) private productRepository: Repository<Product>;

    async createProduct(createProductDto: createProductDto): Promise<Product> {
        const newProduct = this.productRepository.create(createProductDto);
        return await this.productRepository.save(newProduct)
            .then(data => data)
            .catch(err => { throw err });
    }
}



export class PaperRiceService extends ProductService {
    @InjectRepository(PaperRice) private paperRiceRepository: Repository<PaperRice>;

    async createProduct(createProductDto: createProductDto): Promise<Product> {
        const newPaperRice = this.paperRiceRepository.create({ ...createProductDto.product_attributes });
        await this.paperRiceRepository.save(newPaperRice)
            .then(data => data)
            .catch(err => { throw err });
        return await super.createProduct(createProductDto);
    }

}