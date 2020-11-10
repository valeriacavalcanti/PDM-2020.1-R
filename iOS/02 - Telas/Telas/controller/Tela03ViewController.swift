//
//  Tela03ViewController.swift
//  Telas
//
//  Created by Valéria Cavalcanti on 10/11/20.
//

import UIKit

class Tela03ViewController: UIViewController {
    
    var mensagem: String?

    @IBOutlet weak var lbMensagem: UILabel!
    
    
    @IBAction func voltar(_ sender: Any) {
        self.dismiss(animated: true, completion: nil)
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(true)
        
        if let mensagem = self.mensagem{
            self.lbMensagem.text = mensagem
        }
    }
    
}
