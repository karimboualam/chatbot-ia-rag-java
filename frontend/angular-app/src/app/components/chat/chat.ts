import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ChatService } from '../../services/chat.service';
import { ChatMessage } from '../../models/chat-message.model';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './chat.html',
  styleUrls: ['./chat.css']
})
export class ChatComponent {
  messages: ChatMessage[] = [];
  userInput = '';
  loading = false; // 👈 Ajouté : pour afficher "le bot réfléchit..."

  constructor(private chatService: ChatService) {}

  sendMessage() {
    if (!this.userInput.trim()) return;

    // Message utilisateur
    const userMessage: ChatMessage = {
      sender: 'user',
      message: this.userInput,
      timestamp: new Date()
    };
    this.messages.push(userMessage);

    this.loading = true; // 👈 Le bot commence à réfléchir

    // Envoi du message au backend
    this.chatService.sendMessage(this.userInput).subscribe({
      next: (response) => {
        const botMessage: ChatMessage = {
          sender: 'bot',
          message: response.message,
          timestamp: new Date()
        };
        this.messages.push(botMessage);
        this.loading = false; // ✅ Réponse reçue
      },
      error: () => {
        this.messages.push({
          sender: 'bot',
          message: '⚠️ Erreur de communication avec le serveur.',
          timestamp: new Date()
        });
        this.loading = false;
      }
    });

    this.userInput = '';
  }
}
