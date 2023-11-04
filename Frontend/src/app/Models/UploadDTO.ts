import { Usuario } from "./Usuario"

export class UploadDTO{
    id: number = 0
    fechaCreacion!: Date
    rate: number = 0
    descripcion: string = ""
    titulo: string = ""
    u!: {
        id: 0
        username: ""
        email: ""
    }
    l!: {
        id: 0
        titulo: ""
        descripcion: ""
        fechaCreacion: ""
    }
}