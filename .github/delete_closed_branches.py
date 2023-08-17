import requests

def delete_closed_branches(username, repo_name, access_token):
    url = f'https://api.github.com/repos/{username}/{repo_name}/branches'
    headers = {
        'Authorization': f'Bearer {access_token}'
    }

    response = requests.get(url, headers=headers)
    branches = response.json()

    for branch in branches:
        if branch['protected'] or branch['name'] == 'main' or branch['name'] == 'master':
            continue
        if branch['commit']['sha'] == branch['protected_branch']['commit']['sha']:
            branch_name = branch['name']
            delete_url = f'https://api.github.com/repos/{username}/{repo_name}/git/refs/heads/{branch_name}'
            
            delete_response = requests.delete(delete_url, headers=headers)
            if delete_response.status_code == 204:
                print(f"Deleted branch: {branch_name}")
            else:
                print(f"Failed to delete branch: {branch_name}")
                print(delete_response.json())

if __name__ == "__main__":
    username = 'saketksinha'
    repo_name = 'Simple_Telegram_Chatbot'
    access_token = 'SECRET_TOKEN'
    
    delete_closed_branches(username, repo_name, access_token)
