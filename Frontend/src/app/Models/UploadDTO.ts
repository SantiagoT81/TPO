import { Libro } from "./Libro"
import { Usuario } from "./Usuario"

export class UploadDTO{
    id!: number
    fechaCreacion!: Date
    rate!: number 
    descripcion!: string 
    titulo!: string 
    u!: Usuario
    l!: Libro
}