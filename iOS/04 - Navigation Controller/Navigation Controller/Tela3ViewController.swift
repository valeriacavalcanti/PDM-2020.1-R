//
//  Tela3ViewController.swift
//  Navigation Controller
//
//  Created by Valéria Cavalcanti on 01/12/20.
//

import UIKit

class Tela3ViewController: UIViewController {

    @IBOutlet weak var lbMensagem: UILabel!
    var mensagem: String?
    
    @IBAction func salvar(_ sender: Any) {
        // remover tela3 do topo da pilha na navigation controller
        self.navigationController?.popViewController(animated: true)
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        
        if let mensagem = self.mensagem{
            self.lbMensagem.text = mensagem
        }
    }
    
}
