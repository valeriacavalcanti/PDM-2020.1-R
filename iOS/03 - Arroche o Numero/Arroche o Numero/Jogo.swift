//
//  Jogo.swift
//  Arroche o Numero
//
//  Created by Valéria Cavalcanti.
//

import Foundation

class Jogo: NSObject {
    var menor: Int
    var maior: Int
    var numero: Int

    override var description: String{
        return "\(self.menor) - \(self.maior) - \(self.numero)"
    }

    init(menor: Int, maior: Int){
        self.menor = menor
        self.maior = maior
        self.numero = Int.random(in: self.menor + 1 ..< self.maior)
    }
    
    func valido(chute: Int) -> Bool {
        return (chute != self.numero) && (chute > self.menor) && (chute < self.maior)
    }
    
    func atualiza(chute: Int) {
        if (chute < self.numero){
            self.menor = chute
        }else{
            self.maior = chute
        }
    }
    
    func arrochado() -> Bool {
        return self.menor + 1 == self.maior - 1
    }
}
