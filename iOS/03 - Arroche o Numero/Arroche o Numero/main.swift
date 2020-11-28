//
//  main.swift
//  Arroche o Numero
//
//  Created by Valéria Cavalcanti.
//

import Foundation

var jogo = Jogo(menor: 1, maior: 100)

print("Número: ", jogo.numero)

print("Informe seu chute(\(jogo.menor) - \(jogo.maior)): ")
var numero = Int(readLine()!)

while (jogo.valido(chute: numero!)){
    jogo.atualiza(chute: numero!)
    
    if (jogo.arrochado()){
        break
    }else{
        print("Informe seu chute(\(jogo.menor) - \(jogo.maior)): ")
        numero = Int(readLine()!)
    }
}

if (jogo.arrochado()){
    print("Ganhou! Número = ", jogo.numero)
}else{
    print("Perdeu! Número = ", jogo.numero)
}
