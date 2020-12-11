//
//  ViewController.swift
//  Pessoas
//
//  Created by Valéria Cavalcanti on 11/12/20.
//

import UIKit

class FormViewController: UIViewController {
    @IBOutlet weak var tfNome: UITextField!
    @IBOutlet weak var tfIdade: UITextField!
    
    var cadastro: Cadastro?
    
    
    @IBAction func salvar(_ sender: Any) {
        let nome = self.tfNome.text
        let idade = Int(self.tfIdade.text!)
        
        let pessoa = Pessoa(nome: nome!, idade: idade!)
        
        self.cadastro?.add(pessoa: pessoa)
        
        self.navigationController?.popViewController(animated: true)
    }
    
}

