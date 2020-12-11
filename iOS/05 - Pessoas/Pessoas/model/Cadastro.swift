//
//  Cadastro.swift
//  Pessoas
//
//  Created by Valéria Cavalcanti on 11/12/20.
//

import Foundation

class Cadastro {
    var lista: Array<Pessoa>
    
    init() {
        self.lista = Array()
    }
    
    func add(pessoa: Pessoa) {
        self.lista.append(pessoa)
    }
    
    func count() -> Int {
        return self.lista.count
    }
    
    func get() -> Array<Pessoa> {
        return self.lista
    }
    
    func get(index: Int) -> Pessoa {
        return self.lista[index]
    }
    
    func del(index: Int) {
        self.lista.remove(at: index)
    }
    
    func mov(from: Int, to: Int) {
        //
    }
}
